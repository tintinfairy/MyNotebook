public class Main {

    public static void main(String[] args) {
        Notebook notebook = new Notebook(5);
        String date = "12.03.1978";
        String information = "I had a great day in Berlin!";

        String date1 = "14.03.1978";
        String information1 = "All day in Rome. Awesome";

        String date2 = "18.03.1978";
        String information2 = "Going to LA next week) Can't wait";

        System.out.println("adding notes in notebook");
        notebook.addNote(date, information);
        notebook.addNote(date1, information1);
        notebook.addNote(date2, information2);

        System.out.println("printing all notes");
        notebook.printAllNotes();

        System.out.println("deleting one chosen by number note");
        notebook.deleteNote(1);

        System.out.println("printing all notes");
        notebook.printAllNotes();

        System.out.println("deleting one chosen by number note, but element doesn't exist!!!");
        notebook.deleteNote(2);

        System.out.println("printing one chosen by number note");
        System.out.println(notebook.getNote(1));

        System.out.println("editing one chosen by number note");
        notebook.editNote(1, "12.03.1978", "I had a great day in Berlin!");

        System.out.println("printing all notes");
        notebook.printAllNotes();

    }
}