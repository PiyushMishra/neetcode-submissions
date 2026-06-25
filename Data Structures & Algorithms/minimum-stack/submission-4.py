from typing import NamedTuple, List


class Pair(NamedTuple):
    val: int
    min: int


class MinStack:

    def __init__(self):
        self.stack: List[Pair] = []

    def push(self, val: int) -> None:
        if self.stack:
            self.stack.append(
                Pair(val, min(val, self.stack[-1].min))
            )
        else:
            self.stack.append(Pair(val, val))

    def pop(self) -> None:
        if self.stack:
            self.stack.pop()

    def top(self) -> int:
        if self.stack:
            return self.stack[-1].val
        return None

    def getMin(self) -> int:
        if self.stack:
            return self.stack[-1].min
        return None