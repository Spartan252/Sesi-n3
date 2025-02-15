






C_Relacion = [(27,27),(27,44),(44,27),(44,44),(23,1),(23,2)]


Menor = []
temporal = 51
for x in C_Relacion:
    for y in x:
        if y > temporal:
            Menor.append(x)
        temporal = y
    temporal = 51
print(Menor)
