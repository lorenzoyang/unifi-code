.data
array: .byte 40

.text
test:
    la t0, array
    
    li t1, 5
    sw t1, 0(t0)
    
    li t1, 10
    sw t1, 4(t0)
    
    mv a2, t0 # argomento: vettore
    li a3, 0 # il primo elemento del vettore
    jal SwapWithNext
    
    lw a0, 0(t0)
    li a7, 1
    ecall
    
    li a0, 10 # 10 = '\n'
    li a7, 11
    ecall
    
    lw a0, 4(t0)
    li a7, 1
    ecall
    
    li a7, 10 # system call: exit
    ecall
    
    

# Function: SwapWithNext
# Description: scambiare l'elemento del vettore con il successivo
# Parameters: 
#     - a2, vettore
#     - a3: l'indice di un elemento del vettore
# Returns: none
SwapWithNext:
    slli t0, a3, 2 # t0 = a3 * 4
    add t0, a2, t0 # t0 punta all'elemento dell'indice a3
    
    lw t1, 0(t0) # caricare l'elemento[a3] nel t1
    lw t2, 4(t0) # caricare l'elemento successivo
    
    sw t2, 0(t0) # v[a3] = 
    sw t1, 4(t0) # v[a3 + 1] =
    
    ret
