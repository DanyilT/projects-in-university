# ----------------------------------------------------------- 
# Makefile
#
# Options:
# 1. TMLIB = /home/student/os/ThreadMentor/Visual/libthreadclass.a
# 2. TMLIB = /home/student/os/ThreadMentor/NoVisual/libthreadclass.a
# ----------------------------------------------------------- 

CC        = c++
CFLAGS    = -g -O2 -Wno-deprecated -m32
DFLAGS    = -DPACKAGE=\"threadsystem\" -DVERSION=\"1.0\" -DPTHREAD=1 -DUNIX_MSG_Q=1 -DSTDC_HEADERS=1
IFLAGS    = -I/home/student/os/ThreadMentor/include
TMLIB     = /home/student/os/ThreadMentor/Visual/libthreadclass.a

OBJ_FILE  = Philosopher.o Philosopher-main.o
EXE_FILE  = Philosopher

${EXE_FILE}: ${OBJ_FILE}
	${CC} ${CFLAGS}  -o ${EXE_FILE}  ${OBJ_FILE} ${TMLIB} -lpthread

Philosopher.o: Philosopher.cpp Philosopher.h
	${CC} ${DFLAGS} ${IFLAGS} ${CFLAGS} -c Philosopher.cpp

Philosopher-main.o: Philosopher-main.cpp Philosopher.h
	${CC} ${DFLAGS} ${IFLAGS} ${CFLAGS} -c Philosopher-main.cpp

clean:
	rm -f ${OBJ_FILE} ${EXE_FILE}

# End of Makefile
