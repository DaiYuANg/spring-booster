package org.toolkit.spring.boot.recorder.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.toolkit.spring.boot.persistence.base.SuperId;

@Entity
@Table(name = "recording")
public class Recording extends SuperId {}
