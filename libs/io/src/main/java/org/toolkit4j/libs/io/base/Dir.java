package org.toolkit4j.libs.io.base;

import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNode;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.NotDirectoryException;
import java.nio.file.Path;
import java.util.*;
import lombok.SneakyThrows;
import lombok.val;
import org.jetbrains.annotations.NotNull;

public class Dir {
	private final File internalFile;

	private List<Tree<Path>> pathTree;

	public Dir(@NotNull File internalFile) {
		checkIsDirectory(internalFile);
		this.internalFile = internalFile;
	}

	public Dir(@NotNull String internalFile) {
		val internal = new File(internalFile);
		checkIsDirectory(internal);
		this.internalFile = internal;
	}

	@SneakyThrows
	private void checkIsDirectory(@NotNull File dir) {
		if (!dir.isDirectory()) throw new NotDirectoryException(internalFile.getAbsolutePath());
	}

	public File internal() {
		return internalFile;
	}

	public List<TreeNode<Path>> listFiles(Path rootPath) {
		val ns = new ArrayList<>();
		for (Path path : listFile()) {
			System.err.println(ns);
			TreeNode<Path> pathTreeNode =
					new TreeNode<>(path.normalize(), path.getParent(), path.toString(), (Comparable<Path>)
							o -> o.compareTo(o.getParent()));
			if (Files.isDirectory(path) && Objects.requireNonNull(path.toFile().listFiles()).length == 0) {
				listFiles(path);
			}
		}
		return null;
	}

	public List<TreeNode<Path>> listFiles() {
		return listFiles(Path.of(internalFile.getAbsolutePath()));
	}

	public Optional<File> search(String filename) {
		// val ns = listFile().stream()
		// .map(path -> new TreeNode<>(path.normalize(), path.getParent(),
		// path.toString(), (Comparable<Path>) o -> o.compareTo(o.getParent())))
		// .toList();
		// this.pathTree = TreeUtil.build(ns,Path.of(internalFile.getAbsolutePath()));
		// System.err.println(pathTree);
		return Optional.empty();
	}

	public List<Path> listFile() {
		val files = internalFile.listFiles();
		if (Objects.isNull(files)) return new ArrayList<>();
		return Arrays.stream(files).map(file -> Path.of(file.getAbsolutePath())).toList();
	}
}
