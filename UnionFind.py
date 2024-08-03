class UnionFind:
    def __init__(self, n):
        self.par = [i for i in range(n)]
        self.rank = [1] * n
    
    def find(self, x):
        if x == self.par[x]:
            return x
        else:
            result = self.find(self.par[x])
            # path compression
            self.par[x] = result
            return result
    
    def union(self, x1, x2):
        p1 = self.find(x1)
        p2 = self.find(x2)

        if p1 == p2:
            return False
        
        # Union by rank
        if self.rank[p1] > self.rank[p2]:
            self.par[p2] = p1
            self.rank[p1] += self.rank[p2]
        else:
            self.par[p1] = p2
            self.rank[p2] += self.rank[p1]
        
        return True