//
// This is the parentchild.c program: when run, the resulting process
// duplicates itself so that we have both a parent and a child version
// in RAM. The child version then replaces itself in RAM with a new
// process, by loading and running the xeyes program into its memory space.
//
#include <sys/wait.h>
#include <stdio.h>
#include <unistd.h>

int main() {
  // Declare a variable pid, of data type pid_t. Essentially, this
  // is an integer that can store a Process ID number.
  pid_t pid;

  // Fork a child process: this duplicates this etire parentchild
  // program, so that we then have two processes in RAM:
  //     a parent “parentchild” process, and
  //     a new child “parentchild” process, which is a duplicate
  //     of the parent
  pid = fork();

  if (pid < 0) {
    // ...if pid < 0 => An error has occurred with fork(): pid should
    // be greater than or equal to 0. Print an error message to
    // UNIX/Linux Standard Error device (which, by default is the console).
    fprintf(stderr, "Fork Failed\n");
    return 1;
  } else if (pid == 0) {
    // ...the fork() system call returns a ZERO value to the CHILD process,
    // which is assigned to the variable, pid. So, if pid = 0
    // => this version of  the process is the child
    // Get the child to print a message to the console
    printf("Child: I am running...\n");

    // The execlp() system call replaces the puplicated “parentchild”
    // process code in RAM (the child process) with the code from
    // the xeyes program, found in the /usr/bin directory
    execlp("/usr/bin/xeyes", "Xeyes", NULL);
  } else {
    // ...the fork() system call returns the child's Process ID (a positive
    // integer) to the PARENT process

    // Put the parent to sleep for 5 seconds. We do this just to give
    // time for the child's print statement appear on the console first
    // It's not actually needed – Kevin thought this was a good idea! :-)
    sleep(5);

    // Afteer sleeping for 5 seconds, get the parent to print some messages
    printf("Parent: I am running...");
    printf("Parent: I am waiting until Child is terminated by the user!\n");

    // This wait() system call forces the parent to wait for the child
    // to terminate. The parent process does not processed beyond this
    // statement until the parent receives a signel from the child
    // that it (the child) the teerminated
    wait(NULL);

    // This printf() statement is executed after the parent finishes waiting
    // That is, after the child has been terminated, and has sent a signal
    // to the parent
    printf("Parent: finished waiting because child terminated by user!\n");
  }

  return 0;
}
