import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume r) {
        int index = checkIndex(r.getUuid());

        if (index == -1) {
            System.out.println("This resume not in storage to update");
        } else {
            storage[index] = r;
        }
    }

    public void save(Resume r) {
        int index = checkIndex(r.getUuid());

        if (size >= storage.length) {
            System.out.println("Storage overflow");
        } else if (index == -1) {
            storage[size] = r;
            size++;
        } else {
            System.out.println("This resume already in storage");
        }
    }

    public Resume get(String uuid) {
        int index = checkIndex(uuid);

        if (index == -1) {
            System.out.println("This resume not in storage to get");
            return null;
        } else {
            return storage[index];
        }
    }

    public void delete(String uuid) {
        int index = checkIndex(uuid);

        if (index == -1) {
            System.out.println("This resume not in storage to delete");
        } else {
            size--;
            storage[index] = storage[size];
            storage[size] = null;
        }

    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int checkIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }

    public int size() {
        return size;
    }
}
