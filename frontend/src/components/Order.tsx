import Login from "./Login";
import Dashboard from "./Dashboard";
import useToken from "../utils/useToken";

export default function Order() {
    const {token, setToken} = useToken();

    if(!token) {
        return <Login setToken={setToken} />
    }

    return (
        <Dashboard />
    )
}