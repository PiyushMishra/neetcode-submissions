class Solution {
    public int[] getOrder(int[][] tasks) {

        int n = tasks.length;

       Comparator<Task> cmp = new Comparator<Task>() {
            public int compare(Task a, Task b) {
                if (a.processTime != b.processTime)
                    return a.processTime - b.processTime;
                return a.index - b.index;
            }
        };

        PriorityQueue<Task> heap = new PriorityQueue<>(cmp);

        int[] res = new int[n];

        List<Task> tasksList = IntStream
            .range(0, n)
            .mapToObj(i -> new Task(tasks[i][0], tasks[i][1], i))
            .collect(Collectors.toList());

        Collections.sort(tasksList,
            Comparator.comparingInt(t -> t.enqueueTime));

        int time = 0;
        int i = 0;
        int done = 0;

        while (done < n) {

            while (i < n && tasksList.get(i).enqueueTime <= time) {
                heap.offer(tasksList.get(i));
                i++;
            }

            if (heap.isEmpty()) {
                time = tasksList.get(i).enqueueTime;
            } else {
                Task task = heap.poll();
                res[done++] = task.index;
                time += task.processTime;
            }
        }

        return res;
    }
}

class Task {
    int enqueueTime;
    int processTime;
    int index;

    Task(int enqueueTime, int processTime, int index) {
        this.enqueueTime = enqueueTime;
        this.processTime = processTime;
        this.index = index;
    }
}
