#define ROWS 5
#define COLUMNS 5
#define SIMULATION_DURATION 5
#define MUTEX_INITAL_VALUE 1
#define BARRIER_INITIAL_VALUE 0
#define USERS 5

typedef struct{
    int barrier_counter;
    int users_counter;
    char matrix[ROWS][COLUMNS];
}shared_board;