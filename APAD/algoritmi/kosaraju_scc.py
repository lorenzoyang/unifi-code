def transpose_graph(graph):
    transposed = {node: [] for node in graph}

    for node in graph:
        for neighbor in graph[node]:
            if neighbor not in transposed:
                transposed[neighbor] = []
            transposed[neighbor].append(node)

    return transposed


def kosaraju_scc(graph):
    visited = set()
    finish_order = []

    def dfs_first(node):
        visited.add(node)

        for neighbor in graph.get(node, []):
            if neighbor not in visited:
                dfs_first(neighbor)

        # Il nodo viene aggiunto quando la sua esplorazione è completata
        finish_order.append(node)

    # Prima DFS sul grafo originale per determinare l'ordine di completamento dei nodi
    for node in graph:
        if node not in visited:
            dfs_first(node)

    # Costruzione del grafo trasposto
    transposed = transpose_graph(graph)

    visited.clear()
    sccs = []

    def dfs_second(node, component):
        visited.add(node)
        component.append(node)

        for neighbor in transposed.get(node, []):
            if neighbor not in visited:
                dfs_second(neighbor, component)

    # Seconda DFS su G^T in ordine decrescente di tempo di fine
    for node in reversed(finish_order):
        if node not in visited:
            component = []
            dfs_second(node, component)
            sccs.append(component)

    return sccs
