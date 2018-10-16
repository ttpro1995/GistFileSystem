package me.thaithien.gist.gistfilesystem.object;

public class Partition {
    public final long id;
    public final String content;

    public Partition(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }


}
