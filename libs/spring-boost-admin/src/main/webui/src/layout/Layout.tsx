import {AppShell, Container, NavLink} from "@mantine/core";
import {Outlet} from "react-router";
import {useDisclosure} from "@mantine/hooks";
import {IconDashboard} from "@tabler/icons-react";

const Layout = () => {
  const [opened] = useDisclosure();

  return (
    <AppShell
      header={{height: 0}}
      navbar={{width: 300, breakpoint: 'sm', collapsed: {mobile: !opened}}}
      padding="md"
    >
      <AppShell.Navbar p="md">
        <NavLink
          href="#required-for-focus"
          label="Index"
          leftSection={<IconDashboard size={16} stroke={1.5}/>}
        />
        <NavLink
          href="#required-for-focus"
          label="Logging"
          leftSection={<IconDashboard size={16} stroke={1.5}/>}
        />
      </AppShell.Navbar>
      <AppShell.Main>
        <Container fluid>
          <Outlet/>
        </Container>
      </AppShell.Main>
    </AppShell>
  )
}

export {Layout}