from sys import setrecursionlimit as srl
srl(10**5)

rr = raw_input
rri = lambda: int(rr())
rrm = lambda: map(int, rr().split())


def solve(N, K, P, A):
    prefixes = []
    for row in A:
        Pr = [0]
        for x in row:
            Pr.append(Pr[-1] + x)
        prefixes.append(Pr)
    
    # print prefixes
    memo = {}
    def dp(i, take):
        if take == 0 or i == N:
            return 0
        if (i, take) in memo:
            print memo[i, take]
            print memo
            return memo[i, take]

        ans = 0
        for choice in xrange(K+1):
            take2 = take - choice
            if take2 < 0: break
            cand = dp(i+1, take2) + prefixes[i][choice]
            if cand>ans:ans=cand
    
        memo[i, take] = ans
        return ans
    return dp(0, P)


T = rri()
for tc in xrange(1, T + 1):
    N,K, P = rrm()
    A = [rrm() for _ in xrange(N)]
    ans = solve(N, K, P, A)
    print "Case #{}: {}".format(tc, ans)
