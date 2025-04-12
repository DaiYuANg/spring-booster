import {createBrowserRouter} from "react-router";
import {Layout} from "./layout/Layout.tsx";
import {Index} from "./pages/dashboard";

const router = createBrowserRouter([
  {
    path: "/",
    element: <Layout/>,
    children: [
      {
        path: '/',
        element: <Index/>
      }
    ]
  },
]);

export {router}