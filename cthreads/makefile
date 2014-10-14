CC = gcc -pthread
OBJ = lab2.o
BIN = lab2

$(BIN): $(OBJ)
	$(CC) $(OBJ) -o $(BIN)

.c.o:
	$(CC) -c $<

clean:
	rm *.o $(BIN)
