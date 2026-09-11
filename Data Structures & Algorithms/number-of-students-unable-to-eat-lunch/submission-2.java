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
            while(notEatenSandwiches < studentsQueue.size() && studentsQueue.peek() != sandwich) {
                studentsQueue.offer(studentsQueue.poll());
                notEatenSandwiches++;
            }
            if (studentsQueue.peek() == sandwich) {
                studentsQueue.poll();
            } else {
                break;
            }

        }
        return notEatenSandwiches;
    }
}