import React from 'react';
import { Breadcrumb, Layout, Menu, theme } from 'antd';
import './App.css';
import { FileOutlined, PieChartOutlined, UserOutlined, DesktopOutlined, TeamOutlined } from '@ant-design/icons';
import { useState } from 'react';
import { ReactComponent as Logo } from './img/Logo.svg';
import { BrowserRouter as Router, Route, Link,  Switch} from "react-router-dom";
//import XCheckboxes from './conponents/AllEvents';


const { Header, Content, Footer, Sider } = Layout;
function getItem(label, key, icon, children) {
  return {
    key,
    icon,
    children,
    label,
  };
}
const items = [
  getItem('Главная', '1', <PieChartOutlined />),
  getItem('Be ITMO', '2', <DesktopOutlined />),
  getItem('Мероприятия', 'sub1', <UserOutlined />, [
    getItem('Мои мероприятия', '3'),
    getItem('Запись', '4'),
  ]),
  getItem('Задачи', '5', <TeamOutlined />),
];
const App = () => {
  const [collapsed, setCollapsed] = useState(false);
  const {
    token: { colorBgContainer },
  } = theme.useToken();
  return (
    <Router>
    <Layout
      style={{
        minHeight: '100vh',
      }}
    >
      <Sider collapsible collapsed={collapsed} onCollapse={(value) => setCollapsed(value)} 
      style={{
        padding: 0,
        background: colorBgContainer,
      }}>
        <Logo/>
        <div className="demo-logo-vertical" />
        <Menu  defaultSelectedKeys={['1']} mode="inline" items={items} />
      </Sider>
      <Layout>
        <Header
          style={{
            padding: 0,
            background: colorBgContainer,
          }}
        />
        <Content
          style={{
            margin: '0 16px',
          }}
        >
          <Breadcrumb
            style={{
              margin: '16px 0',
            }}
          >
          </Breadcrumb>
          <div
            style={{
              padding: 24,
              minHeight: 360,
              background: colorBgContainer,
            }}
          >
            {/* <Switch>
              <Route exact path="/" component={Home} />
              <Route path="/main" component={Login} />
              <Route path="/myevents" component={Signup} />
              <Route path="/allevents" component={User} onEnter={this.requireAuth}/>
              <Route path="/status" component={Notfound} />
              <Route path="/tasks" component={Notfound} />
            </Switch> */}
          </div>
        </Content>
      </Layout>
    </Layout>
    </Router>
  );
};
export default App;