CC = gcc -pthread
OBJ = cthreads.o
BIN = cthreads

$(BIN): $(OBJ)
	$(CC) $(OBJ) -o $(BIN)

.c.o:
	$(CC) -c $<

clean:
	rm *.o $(BIN)
