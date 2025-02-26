all: pi_paralela pi_serial

pi_paralela: pi_paralela.c
        cc pi_paralela.c -o pi_paralela -lm -pthread


pi_serial: pi_serial.c

        gcc pi_serial.c -o pi_serial -lm