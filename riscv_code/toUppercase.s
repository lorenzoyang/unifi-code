.data
    # la stringa da convertire
    # \0 funziona da 'null terminator'
    str: .string "hello world\0"

.text
main:
    la a2, str # argomento della funzione 'insertNullToEndString'
    jal InsertNullToEndString
    
    la a2, str # argomento della funzione 'printString'
    jal PrintlnString
    
    la a2, str # argomento della funzione 'toUpperCase'
    jal ToUpperCase
    
    la a2, str # argomento della funzione 'printString'
    jal PrintlnString
    
    li a7, 10 # system call: exit
    ecall
    
# argument: a2, stringa da convertire
#     stringa passata per 'riferimento'
# return: none
ToUpperCase:
    addi sp, sp, -4
    sw ra, 0(sp)
    
    cycle_0:
        lbu t0, 0(a2) # carattere attuale
        
        beq t0, zero end_0 # se null salta a 'fine'
        
        # se carattere minuscolo
        li t1, 97 # il valore ascii di 'a'
        li t2, 122 # il valore ascii di 'z'
        
        blt t0, t1, next_0 # se carattere < 'a'
        bgt t0, t2, next_0 # se carattere > 'z'
        
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
        
# argument: a2, la stringa da stampare
# return: none
PrintlnString:
    addi sp, sp, -4
    sw ra, 0(sp)
    
    mv a0, a2 # argomento del system call
    li a7, 4 # system call: print string
    ecall
    
    li a0, 10 # stampare \n
    li a7, 11
    ecall
    
    lw ra, 0(sp)
    addi sp, sp, 4
    ret
    
# argument: a2, la stringa in cui inserire null (0)
#     stringa passata per 'riferimento'
# return: none
InsertNullToEndString:
    addi sp, sp, -4
    sw ra, 0(sp)
    
    li t0, 92 # t0 = backslash (92 ascii)
    cycle_1:
        lbu t1, 0(a2) # carattere attuale
        bne t1, t0 next_1 # se diverso dal backslash, prossimo ciclo
        # altrimenti
        li t3, 48 # t3 = '0' (48 ascii)
        mv t2, a2 # temp per non perdere a2
        addi t2, t2, 1 # punta al prossimo carattere
        lbu t2, 0(t2) # carico il prossimo carattere
        bne t2, t3 next_1 # se diverso da '0', prossimo ciclo
        # altrimenti
        sb zero 0(a2) # inserisco lo zero nel a2
        
        end_1:
            lw ra, 0(sp)
            addi sp, sp, 4
            ret
        
        next_1:
            addi a2, a2, 1 # incremento a2 di 1
            j cycle_1 # prossimo ciclo
        
            
            
            
        
    