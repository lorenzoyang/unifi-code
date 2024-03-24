.data
n: .word 6
errorMsg: .string "n deve essere un numero positivo"
resultMsg: .string "il valore del fattoriale: "

.text
test:
    lw t0, n
    bge t0, zero, input_is_ok # se n >= 0, input_is_ok
    
    la a2 errorMsg
    jal PrintString
    j end_1
    
    input_is_ok:
        la a2, resultMsg
        li a3, 1
        jal PrintString
        
        lw a2, n
        jal Factorial
        
        mv a0, a2
        li a7, 1 # System Call: 'PrintInt'
        ecall
        
    end_1:
        li a7 10 # exit from programm
        ecall



# Function: Factorial
# Description: calcola il fattoriale di un dato intero positivo
# Parameters: 
#     - a2: n, numero intero >= 0
# Returns: 
#     - a2, il risultato del fattoriale
Factorial:
    # se n == 0 restituisce 1
    beqz a2, caso_base
    
    caso_induttivo:
        addi sp, sp -8
        sw ra, 0(sp)
        sw a2, 4(sp) # salvo n
    
        addi a2, a2, -1 # decremento n di 1
        jal Factorial # calcolo Factorial(n-1)
    
        mv t1, a2 # salvo il risultato del 'Factorial' precedente
        lw a2 4(sp) # riprendo n
        mul a2, a2, t1
    
        lw ra, 0(sp) # riprendo ra
        addi sp, sp, 8
        ret

    caso_base:
        li a2 1 # restituisce 1
        ret
# End
     


# Function: PrintString
# Description: stampare la stringa
# Parameters: 
#     - a2, la stringa da stampare
#     - a3: se 1 non aggiunge '\n'
# Returns: none
PrintString:
    addi sp, sp, -4
    sw ra, 0(sp)
    
    mv a0, a2
    li a7, 4 # system call: 'PrintString'
    ecall
    
    li t0, 1
    beq a3, t0 end_2 # se 0 allora 'fine'
    
    # altrimenti '\n'
    li a0, 10 # 10 = '\n'
    li a7, 11
    ecall
    
    end_2:
        lw ra, 0(sp)
        addi sp, sp, 4
        ret
# End


