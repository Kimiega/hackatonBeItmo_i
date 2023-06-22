import React from "react";
import type { MenuProps } from "antd";
import { ScheduleOutlined, UserOutlined } from "@ant-design/icons";
import { Breadcrumb, Layout, Menu, theme } from "antd";
import { Navigate } from "react-router-dom";
import { paths } from "./router";

const { Content, Footer, Sider } = Layout;

const sections: MenuProps["items"] = [
  {
    key: "shedule",
    icon: React.createElement(ScheduleOutlined),
    label: "Расписание",
  },
  {
    key: "profile",
    icon: React.createElement(UserOutlined),
    label: "Be Itmo",

    children: [
      {
        key: "profile",
        label: "Персональная страница",
        onClick: () => <Navigate to={paths.PROFILE} />,
      },
      {
        key: "events",
        label: "События",
        onClick: () => <Navigate to={paths.EVENTS} />,
      },
    ],
  },
];

export type PageTemplateProps = {
  content: React.ReactNode;
};

export const PageTemplate = ({ content }: PageTemplateProps) => {
  const {
    token: { colorBgContainer },
  } = theme.useToken();

  return (
    <Layout>
      <Content style={{ padding: "0 50px" }}>
        {/* <Breadcrumb style={{ margin: "16px 0" }}>
          <Breadcrumb.Item>Home</Breadcrumb.Item>
          <Breadcrumb.Item>List</Breadcrumb.Item>
          <Breadcrumb.Item>App</Breadcrumb.Item>
        </Breadcrumb> */}
        <Layout style={{ padding: "24px 0", background: colorBgContainer }}>
          <Sider style={{ background: colorBgContainer }} width={200}>
            <Menu
              mode="inline"
              defaultSelectedKeys={["1"]}
              defaultOpenKeys={["sub1"]}
              style={{ height: "100%" }}
              items={sections}
            />
          </Sider>
          <Content style={{ padding: "0 24px", minHeight: 280 }}>
            {content}
          </Content>
        </Layout>
      </Content>
      <Footer style={{ textAlign: "center" }}>
        Ant Design ©2023 Created by Ant UED
      </Footer>
    </Layout>
  );
};
