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


