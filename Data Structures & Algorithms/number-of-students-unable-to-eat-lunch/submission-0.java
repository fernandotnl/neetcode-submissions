class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        LinkedList<Integer> studentsQueue = new LinkedList<>();
        LinkedList<Integer> sandwichesQueue = new LinkedList<>();
        for(int i=0; i<students.length; i++) {
            studentsQueue.offer(students[i]);
            sandwichesQueue.offer(students[i]);
        }

        int eatenSandwiches = 0;
        int notEatenSandwiches = 0;
        for(int i=0; i<sandwiches.length; i++) {
            notEatenSandwiches = 0;
            int sandwich = sandwiches[i];
            boolean sandwichEaten = false;
            while(!sandwichEaten) {
                int student = studentsQueue.poll();
                if(student == sandwich) {
                    sandwichesQueue.poll();
                    sandwichEaten = true;
                } else {
                    studentsQueue.offer(student);
                    notEatenSandwiches++;
                    if (notEatenSandwiches == studentsQueue.size()) {
                        return notEatenSandwiches;
                    }
                }
                
             }
        }
        return 0;
    }
}