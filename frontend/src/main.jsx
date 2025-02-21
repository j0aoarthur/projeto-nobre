import React from "react";
import ReactDOM from "react-dom/client";
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import { Layout, Menu } from "antd";
import PersonForm from "./PersonForm";
import TaskForm from "./TaskForm";
import "./index.css";

const { Header, Content } = Layout;

const router = createBrowserRouter([
  {
    path: "/create-person",
    element: <PersonForm />,
  },
  {
    path: "/create-task",
    element: <TaskForm />,
  },
]);

const Main = () => {
  return (
    <Layout style={{ minHeight: "100vh" }}>
      <Header>
        <Menu mode="horizontal">
          <Menu.Item key="1">
            <a href="/create-person">Criar Pessoa</a>
          </Menu.Item>
          <Menu.Item key="2">
            <a href="/create-task">Criar Tarefa</a>
          </Menu.Item>
        </Menu>
      </Header>
      <Content style={{ padding: "20px" }}>
        <RouterProvider router={router} />
      </Content>
    </Layout>
  );
};


ReactDOM.createRoot(document.getElementById("root")).render(<Main />);