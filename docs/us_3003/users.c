#include <sys/types.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/syscall.h>
#include <stdlib.h>
#include <string.h>
#include <signal.h>
#include <time.h>
#include <sys/wait.h>
#include <ctype.h>
#include <fcntl.h>
#include <sys/stat.h>
#include <sys/mman.h>
#include <semaphore.h>
#include "configuration.h"

void print_shared_board(shared_board* shared_board, FILE* path){
    fprintf(path, "  |");
    for(int i=0;i<COLUMNS;i++){
        fprintf(path, "  %d  ", i);
    }
    fprintf(path, "\n");
    for(int i=0;i<COLUMNS*COLUMNS;i++){
        if(i == 2){
            fprintf(path, "+");
            continue;
        }
        fprintf(path, "-");
    }
    fprintf(path, "\n");
    for(int i=0;i<ROWS;i++){
        fprintf(path, "%d |", i);
        for(int j=0;j<COLUMNS;j++){
            if(shared_board->matrix[i][j] != 0) {
                fprintf(path, "  %c  ", shared_board->matrix[i][j]);
            } else {
                fprintf(path, "     ");
            }

        }
        fprintf(path, "\n\n");
    }
}

/*
  It should receive:
    - Shared memory name;
    - Mutex 2 semaphore name;
    - Barrier 2 semaphore name;
    - Barrier 3 semaphore name;
    - Barrier 4 semaphore name;
    - Iteration.
*/
int main(int argc, char* argv[]){

    // Pointer to file -> User Point of View.
    FILE* f;

    char user_view[7];
    snprintf(user_view, 7, "user%d", atoi(argv[5]));

    // Creates/opens the file.
    f = fopen(user_view, "a");

    // Mutual exclusion semaphore.
    sem_t* mutex2 = sem_open(argv[1], O_CREAT, 0644, MUTEX_INITAL_VALUE);
    if(mutex2 == SEM_FAILED){
        perror("sem_open");
        exit(EXIT_FAILURE);
    }

    // Barrier semaphore.
    sem_t* barrier2 = sem_open(argv[2], O_CREAT, 0644, BARRIER_INITIAL_VALUE);
    if(barrier2 == SEM_FAILED){
            perror("sem_open");
            exit(EXIT_FAILURE);
    }

    // Barrier semaphore.
    sem_t* barrier3 = sem_open(argv[3], O_CREAT, 0644, BARRIER_INITIAL_VALUE);
    if(barrier3 == SEM_FAILED){
            perror("sem_open");
            exit(EXIT_FAILURE);
    }

    // Barrier semaphore.
    sem_t* barrier4 = sem_open(argv[4], O_CREAT, 0644, BARRIER_INITIAL_VALUE);
    if(barrier4 == SEM_FAILED){
            perror("sem_open");
            exit(EXIT_FAILURE);
    }

    int fd, size = sizeof(shared_board);
    fd = shm_open(argv[0], O_CREAT|O_RDWR, S_IRUSR|S_IWUSR);
    shared_board* addr;
    if(fd < 0){
        perror("shm_open");
        exit(EXIT_FAILURE);
    }

    addr = (shared_board*)mmap(NULL, size, PROT_READ|PROT_WRITE, MAP_SHARED, fd, 0);
    if(addr == MAP_FAILED){
        perror("mmap");
        exit(EXIT_FAILURE);
    }

    alarm(SIMULATION_DURATION*2);
    for(;;){

        // Every process is going to be passively waiting here until shared board suffers a change.
        sem_wait(barrier2);

        // Each one of them is going to print the changes in his file.
        print_shared_board(addr, f);

        // Gains exclusive access to the shared memory and is going to wait for every process to print the shared board.
        sem_wait(mutex2);
        addr->barrier_counter += 1;

        if(addr->barrier_counter == USERS){
            sem_post(barrier3);
        }
        sem_post(mutex2);

        sem_wait(barrier3);
        sem_post(barrier3);

        // Allows the process in the shared_board program to continue his job.
        sem_post(barrier4);
    }
}