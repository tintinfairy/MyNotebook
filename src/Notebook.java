
public class Notebook {

    private int numberOfNotes = 2;
    private int currentNote = -1;
    private String date = "";
    private String information = "";
    private Note[] notes = new Note[numberOfNotes];
    private Note note = new Note(currentNote, date, information);

    Notebook() {
    }

    private static Note[] changeNotebookSize(Note[] notes, int oldSize, int newSize) {
        Note[] newNotes = notes.clone();
        notes = new Note[newSize];
        if (oldSize < newSize) {
            System.arraycopy(newNotes, 0, notes, 0, newNotes.length);
        } else {
            System.arraycopy(newNotes, 0, notes, 0, newNotes.length - 1);
        }
        return notes;
    }


    public void addNote(String date, String information) {
        currentNote++;
        if (currentNote < numberOfNotes) {
            note = new Note(currentNote, date, information);
            notes[currentNote] = note;
        } else {
            int newNumberOfNotes = 2 * numberOfNotes;
            notes = changeNotebookSize(notes, numberOfNotes, newNumberOfNotes);
            note = new Note(currentNote, date, information);
            notes[currentNote] = note;
            numberOfNotes = newNumberOfNotes;
        }
    }

    public void deleteNote(int numToDelete) {
        if (numToDelete > currentNote || numToDelete < 0) {
            System.out.println("There is no note with this number!!!");
        } else {

            for (int i = numToDelete; i < numberOfNotes - 1; i++) {
                if (notes[i + 1] == null) {
                    break;
                } else {
                    notes[i] = notes[i + 1];
                    currentNote = i;
                    notes[i].setNumOfNote(currentNote);
                }
            }
            int newNumberOfNotes = numberOfNotes--;
            notes = changeNotebookSize(notes, numberOfNotes, newNumberOfNotes);
            numberOfNotes = newNumberOfNotes;


        }
    }

    public void editNote(int numToEdit, String date, String information) {
        if (numToEdit > currentNote || numToEdit < 0) {
            System.out.println("There is no note with this number!!!");
        } else {
            notes[numToEdit].setDate(date);
            notes[numToEdit].setInformation(information);
        }
    }

    public String getNote(int numOfNote) {
        if (numOfNote > currentNote || numOfNote < 0) {
            return ("There is no note with this number!!!");
        }
        return notes[numOfNote].toString();

    }

    public void printAllNotes() {
        for (int i = 0; i < currentNote + 1; i++) {
            System.out.println(notes[i].getNumOfNote() + ": <" + notes[i].getDate() + "> " + notes[i].getInformation());
        }
    }
}
