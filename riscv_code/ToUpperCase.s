.data
str: .string "hello world hahahah"

.text
test:
    la a2, str
    jal PrintString
    
    la a2, str
    jal ToUpperCase
    
    la a2, str
    jal PrintString
    
    li a7, 10 # system call: exit
    ecall
    
    

# Function: ToUpperCase
# Description: convertire la stringa in maiuscolo
# Parameters:
#     - a2, la stringa da convertire (passata per 'riferimento')
# Returns: none
ToUpperCase:
    addi sp, sp, -4
    sw ra, 0(sp)
    
    cycle_0:
        lbu t0, 0(a2) # carattere attuale
        
        beq t0, zero end_0 # se 'null' salta
        
        # se carattere minuscolo
        li t1, 97 # 'a'
        li t2, 122 # 'z'
        
        blt t0, t1, next_0 # se < 'a'
        bgt t0, t2, next_0 # se > 'z'
        
        # convertire carattere in maiuscolo sottraendo per 32
        addi t0, t0, -32
        sb t0, 0(a2) # salvo carattere convertito
        
        next_0:
            addi a2, a2, 1 # prossimo carattere
            j cycle_0
        
    end_0:
        lw ra 0(sp)
        addi sp, sp, 4
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


