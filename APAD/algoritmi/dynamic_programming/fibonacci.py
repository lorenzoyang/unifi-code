def fib_standard(n):
    if n <= 1:
        return n
    return fib_standard(n - 1) + fib_standard(n - 2)


def fib_top_down(n, memo=None):
    if memo is None:
        memo = {}

    if n <= 1:
        return n

    if n in memo:
        return memo[n]

    memo[n] = fib_top_down(n - 1, memo) + fib_top_down(n - 2, memo)

    return memo[n]


def fib_bottom_up(n):
    if n <= 1:
        return n

    f = [0] * (n + 1)

    f[0] = 0
    f[1] = 1

    for i in range(2, n + 1):
        f[i] = f[i - 1] + f[i - 2]

    return f[n]


def fib_bottom_up_optimized(n):
    if n <= 1:
        return n

    prev2 = 0
    prev1 = 1

    for _ in range(2, n + 1):
        current = prev1 + prev2
        prev2 = prev1
        prev1 = current

    return prev1


if __name__ == "__main__":
    n = 10

    print(f"fib_standard({n})            = {fib_standard(n)}")
    print(f"fib_top_down({n})            = {fib_top_down(n)}")
    print(f"fib_bottom_up({n})           = {fib_bottom_up(n)}")
    print(f"fib_bottom_up_optimized({n}) = {fib_bottom_up_optimized(n)}")
