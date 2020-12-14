package com.company.Common;

import java.util.ArrayList;

public interface Command {
    public Integer Run (ArrayList<String> args) throws Exception;
}
