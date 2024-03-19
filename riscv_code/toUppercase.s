.data
    str: .string "hello world" # la stringa da convertire

.text
main:
    la t0, str # carico str nel registro t0
    sb zero, 11(t0) # inserisco un null dopo l'ultimo
    
    la a0, str # argomento della funzione 'printString'
    jal printlnString
    
    la a0, str # argomento della funzione 'toUpperCase'
    jal toUpperCase
    
    la a0, str # argomento della funzione 'printString'
    jal printlnString
    
    li a7, 10 # system call: exit
    ecall
    
# argomento: a0, stringa da convertire
toUpperCase:
    addi sp, sp, -4 # alloco memoria nello stack
    sw ra, 0(sp) # salvo l'indirizzo di ritorno
    
    ciclo:
        # t0 = carattere attuale
        lb t0, 0(a0)
        
        beq t0 zero fine # se e' null salta a 'fine'
        
        # controllo se il carattere e' minuscolo
        li t1, 97 # il valore ascii di a
        li t2, 122 # il valore ascii di z
        
        blt t0, t1, prossimo # se il carattere < a
        bgt t0, t2, prossimo # se il carattere > z
        
        # convertire il carattere in maiuscolo sottraendo per 32
        addi t0, t0, -32
        sb t0 0(a0) # salvo il carattere convertito
        
        # prossimo ciclo
        prossimo:
            addi a0, a0, 1 # incremento a0 per ottenere il prossimo carattere
            j ciclo
        
    fine:
        lw ra 0(sp) # ripristino l'indirizzo di ritorno
        addi sp, sp, 4 # libero la memoria dello stack
        ret
        
# argomento: a0, la stringa da stampare
printlnString:
    addi sp, sp, -4
    sw ra, 0(sp)
    
    la a0, str # argomento del system call
    li a7, 4 # system call: print string
    ecall
    
    li a0, 10 # stampare \n
    li a7, 11
    ecall
    
    lw ra, 0(sp)
    addi sp, sp, 4
    ret
