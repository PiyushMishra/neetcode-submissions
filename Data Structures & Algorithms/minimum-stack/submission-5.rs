use std::cmp;

struct Pair {
    value: i32,
    min: i32,
}

struct MinStack {
    vec: Vec<Pair>,
}

impl MinStack {
    pub fn new() -> Self {
        MinStack {
            vec: Vec::<Pair>::new(),
        }
    }

    pub fn push(&mut self, val: i32) {
        let min = if self.vec.is_empty() {
            val
        } else {
            cmp::min(val, self.vec.last().unwrap().min)
        };

        self.vec.push(Pair {
            value: val,
            min,
        });
    }

    pub fn pop(&mut self) {
        self.vec.pop();
    }

    pub fn top(&self) -> i32 {
        if self.vec.is_empty() {
            -1
        } else {
            self.vec.last().unwrap().value
        }
    }

    pub fn get_min(&self) -> i32 {
        if self.vec.is_empty() {
            -1
        } else {
            self.vec.last().unwrap().min
        }
    }
}