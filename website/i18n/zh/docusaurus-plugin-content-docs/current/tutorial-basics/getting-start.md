---
sidebar_position: 1
---

# Getting Start

Add **Markdown or React** files to `src/pages` to create a **standalone page**:

- `src/pages/index.js` → `localhost:3000/`
- `src/pages/foo.md` → `localhost:3000/foo`
- `src/pages/foo/bar.js` → `localhost:3000/foo/bar`

### 前置知识

#### 后端

- [Spring Boot](https://spring.io/projects/spring-boot): 工具包中大部分后端组件 基于`Spring Boot` 以封装Starter形式提供
- ORM: 工具包中的`Starter` 以 `Spring Jpa` 作为ORM库
- 构建工具
  - Maven
  - Gradle:

#### 前端

- [Vue3](https://vuejs.org): 工具包中的前端选型为 Vue3
  - [Quasar](https://quasar.dev): 使用 Quasar 作为基础组件库
  - [Pinia](https://pinia.vuejs.org/): 状态管理
  - [Vue-i18n](https://vue-i18n.intlify.dev/): 多语言库

### 准备工作

- [Node.js](https://nodejs.org/en/download/) 最小版本 19.7 或者更高（stable）
- [Java Development Kit](https://openjdk.org/) 最小版本17 推荐使用 [sdkman](https://sdkman.io/) 安装 JDK 17 或以上版本

## Create your first React Page

Create a file at `src/pages/my-react-page.js`:

```jsx title="src/pages/my-react-page.js"
import React from 'react';
import Layout from '@theme/Layout';

export default function MyReactPage() {
  return (
    <Layout>
      <h1>My React page</h1>
      <p>This is a React page</p>
    </Layout>
  );
}
```

A new page is now available at [http://localhost:3000/my-react-page](http://localhost:3000/my-react-page).

## Create your first Markdown Page

Create a file at `src/pages/my-markdown-page.md`:

```mdx title="src/pages/my-markdown-page.md"
# My Markdown page

This is a Markdown page
```

A new page is now available at [http://localhost:3000/my-markdown-page](http://localhost:3000/my-markdown-page).
