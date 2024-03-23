.data
n: .word 6 # 'input' dell'utente
errorMsg: .string "n deve essere un numero positivo"
resultMsg: .string "il valore del fattoriale: "

.text
main:
    lw t0, n # carico input 'n' in un registro
    bge t0, zero, input_is_ok # se n >= 0 input_is_ok
    # altrimenti
    la a2 errorMsg # argomento della funzione 'PrintlnString'
    jal PrintString
    j end_1
    
    input_is_ok:
        la a2, resultMsg # argomento della funzione 'PrintString'
        li a3, 1 # argomento della funzione 'PrintString'
        jal PrintString
        
        lw a2, n # argomento della funzione 'Factorial'
        jal Factorial
        
        mv a0, a2 # argomento del syscall = fattoriale
        li a7, 1 # System Call: 'PrintInt'
        ecall
        
    end_1:
        li a7 10
        ecall # exit from programm
    
    
    
# argument: a2 (n), un numero intero >= 0
# return: a2, il risultato del fattoriale
Factorial:
    # caso base: se n == 0 restituisce 1
    beqz a2, caso_base
    
    caso_induttivo:
        addi sp, sp -8
        sw ra, 0(sp) # salvo return address
        sw a2, 4(sp) # salvo n
    
        addi a2, a2, -1 # decremento n
        jal Factorial # calcolo Factorial(n-1)
    
        mv t1, a2 # salvo il risultato del Factorial precedente
        lw a2 4(sp) # riprendo n
        mul a2, a2, t1
    
        lw ra, 0(sp) # riprendo ra
        addi sp, sp, 8
        ret

    caso_base:
        li a2 1 # restituisce 1
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