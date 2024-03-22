.data

n: .word 5 # 'input' dell'utente

errorMsg: .string "n deve essere maggiore o uguale a 1"
resultMsg: .string "il valore del fattoriale: "

.text

main:
    li t0, 1 # t0 = 1
    bge a2, t0 input_is_ok # se n >= 1 salto a input_is_ok
    # altrimenti
    la a2 errorMsg # argomento della funzione 'PrintlnString'
    jal PrintString
    
    j end_1
    
    input_is_ok:
        la a2, n # argomento della funzione 'Factorial'
        jal Factorial
        
        la a2, resultMsg # argomento della funzione 'PrintString'
        li a3, 0 # argomento della funzione 'PrintString'
        jal PrintString
        
        mv a0, a0 # return value del fattoriale->argomento del syscall
        li a7, 1 # System Call: 'PrintInt'
        ecall
        
    end_1:
        li a7 10
        ecall # exit from programm
    
# argument: a2, un numero intero >= 1
# return: a0, il risultato del fattoriale
Factorial:
    addi sp, sp -8
    sw ra, 4(sp)
    sw a2, 0(sp) # salvataggio del parametro n
    
    li t0, 1 # t0 = 1
    bge a2, t0 input_is_ok
    
    end_0:
        lw a2, 0(sp)
        lw ra, 4(sp)
        addi sp, sp, 8
        ret
        
# argument: a2, la stringa da stampare
# argument: a3, non aggiungere '\n' se a3 == 1
#     altrimenti un '\n' viene aggiunto
# return: none
PrintString:
    addi sp, sp, -4
    sw ra, 0(sp)
    
    mv a0, a2 # argomento del system call
    li a7, 4 # system call: print string
    ecall
    
    li t0, 1 # costante 1 nel registro t0
    beq a3, t0 end_2 # se uguale a 0 salto alla fine
    
    # altrimenti '\n'
    li a0, 10 # 10 = '\n'
    li a7, 11
    ecall
    
    end_2:
        lw ra, 0(sp)
        addi sp, sp, 4
        ret