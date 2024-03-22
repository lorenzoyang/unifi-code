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