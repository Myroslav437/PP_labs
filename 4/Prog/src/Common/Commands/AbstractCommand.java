package Common.Commands;

public interface AbstractCommand<RES> {
    public RES Run () throws Exception;
}

