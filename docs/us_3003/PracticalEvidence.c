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

#define SEM_NAME_MUTEX "/mutex"
#define SEM_NAME_MUTEX2 "/mutex2"
#define SEM_NAME_BARRIER "/barrier"
#define SEM_NAME_BARRIER2 "/barrier2"
#define SEM_NAME_BARRIER3 "/barrier3"
#define SEM_NAME_BARRIER4 "/barrier4"
#define SHARED_MEMORY_NAME "/shared_memory"
#define USERS 5

void create_post_it(int row, int column, char content, shared_board* shared_board){
    if(shared_board->matrix[row][column] == (char)0){
        shared_board->matrix[row][column] = content;
        printf("User %d created post-it in [%d][%d]...\n", getpid(), row, column);
    }else{
        printf("User %d tried to create a post-it in [%d][%d] but it was already one there...\n", getpid(), row, column);
    }
}

void delete_post_it(int row, int column, shared_board* shared_board){
    if(shared_board->matrix[row][column] != (char)0){
        shared_board->matrix[row][column] = (char) 0;
        printf("User %d deleted post-it in [%d][%d]...\n", getpid(), row, column);
    }else{
        printf("There is no post-it created in [%d][%d] to delete!\n", row, column);
    }
}

//Should it exist?
void update_post_it_content(int row, int column, char new_content, shared_board* shared_board){
    if(shared_board->matrix[row][column] != (char) 0){
        shared_board->matrix[row][column] = new_content;
        printf("User %d updated post-it in [%d][%d]...\n", getpid(), row, column);
    }else{
        printf("There is no post-it in [%d][%d] to update!\n", row, column);
    }
}

// Update content
void change_post_it_position(int orow, int ocolumn, int nrow, int ncolumn, shared_board* shared_board){
    if(shared_board->matrix[orow][ocolumn] != (char) 0 || shared_board->matrix[nrow][ncolumn] != (char) 0){
        shared_board->matrix[nrow][ncolumn] = shared_board->matrix[orow][ocolumn];
        shared_board->matrix[orow][ocolumn] = (char)0;
        printf("User %d changed post-it [%d][%d] to [%d][%d]...\n", getpid(), orow, ocolumn, nrow, ncolumn);
    }
    else{
        printf("The position [%d][%d] had no content at all!\n", orow, ocolumn);
    }
}

void print_shared_board(shared_board* shared_board){
    printf("  |");
    for(int i=0;i<COLUMNS;i++){
        printf("  %d  ", i);
    }
    printf("\n");
    for(int i=0;i<COLUMNS*COLUMNS;i++){
        if(i == 2){
            printf("+");
            continue;
        }
        printf("-");
    }
    printf("\n");
    for(int i=0;i<ROWS;i++){
        printf("%d |", i);
        for(int j=0;j<COLUMNS;j++){
            if(shared_board->matrix[i][j] != 0) {
                printf("  %c  ", shared_board->matrix[i][j]);
            } else {
                printf("     ");
            }

        }
        printf("\n\n");
    }
}

//Choose a function randomly
void choose_function(shared_board* shared_board){

    int option = rand() % 4 + 1;
    int row = rand() % ROWS;
    int column = rand() % COLUMNS;
    char content = (rand() % (90 - 65 + 1)) + 65;

    switch (option)
    {
        case 1:
          create_post_it(row, column, content, shared_board);
          break;
        case 2:
          delete_post_it(row, column, shared_board);
          break;
        case 3:
          update_post_it_content(row, column, content, shared_board);
          break;
        case 4:
          int nrow = rand() %4 + 1;
          int ncolumn = rand() % 4 + 1;
          change_post_it_position(nrow, ncolumn, row, column, shared_board);
          break;
        default:
          printf("Option invalid!");
          break;
    }
}

/**
 * This solution contains 2 types of semaphores:
 *  - Mutexes;
 *  - Barriers.
 *
 * Since the goal is simulate a shared board for many users, we need to make sure that:
 *  - There isn't collisions when two users try to modify the same cell;
 *  - When changes are made, all the users must see it;
 * For that we create USERS (macro) processes that are going to be children (users) and each
 * child process will create a children and send him to run another program (through execlp)
 * and the goal of that processes is simulate the view of each user printing to a specific file
 * the shared board everytime that suffers changes.
*/

int main(){

    // Creation of the mutual exclusion semaphore to access the shared memory.
    sem_t* mutex = sem_open(SEM_NAME_MUTEX, O_CREAT, 0644, MUTEX_INITAL_VALUE);
    if(mutex == SEM_FAILED){
        perror("sem_open");
        exit(EXIT_FAILURE);
    }

    // Creation of another mutual exclusion semaphore to the assist an user barrier.
    sem_t* mutex2 = sem_open(SEM_NAME_MUTEX2, O_CREAT, 0644, MUTEX_INITAL_VALUE);
    if(mutex2 == SEM_FAILED){
        perror("sem_open");
        exit(EXIT_FAILURE);
    }

    // Syncronization semaphore.
    sem_t* barrier = sem_open(SEM_NAME_BARRIER, O_CREAT, 0644, BARRIER_INITIAL_VALUE);
    if(barrier == SEM_FAILED){
            perror("sem_open");
            exit(EXIT_FAILURE);
      }

    sem_t* barrier2 = sem_open(SEM_NAME_BARRIER2, O_CREAT, 0644, BARRIER_INITIAL_VALUE);
    if(barrier2 == SEM_FAILED){
            perror("sem_open");
            exit(EXIT_FAILURE);
    }

    sem_t* barrier3 = sem_open(SEM_NAME_BARRIER3, O_CREAT, 0644, BARRIER_INITIAL_VALUE);
    if(barrier3 == SEM_FAILED){
            perror("sem_open");
            exit(EXIT_FAILURE);
    }

    sem_t* barrier4 = sem_open(SEM_NAME_BARRIER4, O_CREAT, 0644, BARRIER_INITIAL_VALUE);
    if(barrier4 == SEM_FAILED){
            perror("sem_open");
            exit(EXIT_FAILURE);
    }

    // Creation of the "shared board" a.k.a shared memory.
    int fd, size = sizeof(shared_board);
    fd = shm_open(SHARED_MEMORY_NAME, O_CREAT|O_RDWR, S_IRUSR|S_IWUSR);
    shared_board* addr;

    if(fd < 0){
        perror("shm_open");
        exit(EXIT_FAILURE);
    }

    if(ftruncate(fd, size) < 0){
        perror("ftruncate");
        exit(EXIT_FAILURE);
    }


    addr = (shared_board*)mmap(NULL, size, PROT_READ|PROT_WRITE, MAP_SHARED, fd, 0);
    if(addr == MAP_FAILED){
        perror("mmap");
        exit(EXIT_FAILURE);
    }


    // Users creation.
    for(int i=0;i<USERS;i++){
        pid_t p = fork();
        if(p < 0){
            perror("fork");
            exit(EXIT_FAILURE);
        }
        if(p == 0){

            srand(getpid());

            // Each process children is going to fork.
            pid_t p2 = fork();
            if(p2 < 0){
                perror("fork");
                exit(EXIT_FAILURE);
            }
            if(p2 == 0){
                char iteration[2];
                snprintf(iteration, 2, "%d", i);
                execlp("./users", SHARED_MEMORY_NAME, SEM_NAME_MUTEX, SEM_NAME_BARRIER2, SEM_NAME_BARRIER3, SEM_NAME_BARRIER4, iteration, (char*)NULL);
            }

            // Barrier to make sure that all processes forked.
            sem_wait(mutex2);
            addr->users_counter += 1;
            if(addr->users_counter == USERS){
                sem_post(barrier);
            }
            sem_post(mutex2);
            sem_wait(barrier);
            sem_post(barrier);

            alarm(SIMULATION_DURATION);
            for(;;){

                // Gain mutual exclusion to the shared memory.
                sem_wait(mutex2);

                choose_function(addr);

                // Notifies every user that changes were made to the shared board by incrementing USERS times the barrier semaphore.
                for(int i=0;i<USERS;i++){
                    sem_post(barrier2);
                }

                // Wait for every user to see and print the changed shared board.
                for(int i=0;i<USERS;i++){
                    sem_wait(barrier4);
                }

                // This barrier is used in the user program and needs to be with value 0 to in order to work (the last "user" process is going to let this as value one.)
                sem_wait(barrier3);

                // Restarts the barrier counter to "users" processes.
                addr->barrier_counter = 0;

                // Frees the critical zone.
                sem_post(mutex2);

                sleep(rand() % 3);
            }
            exit(EXIT_FAILURE);
        }
    }

    for(int i=0;i<USERS;i++){
        wait(NULL);
    }

    printf("\n\n\n\tEND OF SIMULATION!\n\n\n");

    if(sem_unlink(SEM_NAME_MUTEX) < 0 || sem_unlink(SEM_NAME_BARRIER) < 0 || sem_unlink(SEM_NAME_MUTEX2) < 0 || sem_unlink(SEM_NAME_BARRIER2) < 0
     || sem_unlink(SEM_NAME_BARRIER3) < 0 || sem_unlink(SEM_NAME_BARRIER4) < 0){
        perror("sem_unlink");
        exit(EXIT_FAILURE);
    }

    if(munmap(addr, size) < 0){
        perror("munmap");
        exit(EXIT_FAILURE);
    }

    if(close(fd) < 0){
        perror("close");
        exit(EXIT_FAILURE);
    }

    if(shm_unlink(SHARED_MEMORY_NAME) < 0){
        perror("shm_unlink");
        exit(EXIT_FAILURE);
    }

    exit(EXIT_SUCCESS);
}