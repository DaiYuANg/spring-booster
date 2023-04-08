package org.daiyuang.collections.tree;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TreeNode<T> {
    List<T> children = new ArrayList<>();

    private T id;

    private T parentId;

    public boolean root() {
        return parentId == null;
    }
}
