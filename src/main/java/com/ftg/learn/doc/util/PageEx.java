package com.ftg.learn.doc.util;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class PageEx<T> extends BaseEx{

    int page;

    int pageNum;

    int totalPage;

    List<T> data;
}
