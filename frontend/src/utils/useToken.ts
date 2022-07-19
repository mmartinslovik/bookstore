import {useState} from 'react';

export default function useToken() {
    const getToken = () => {
        const token: string | null = localStorage.getItem('token')
        if (token) {
            return JSON.parse(token)
        }
        return null
    };

    const [token, setToken] = useState(getToken());
    console.log("token", token)

    const saveToken = (token: any) => {
        localStorage.setItem('token', JSON.stringify(token))
        setToken(token)
    };

    return {
        setToken: saveToken,
        token
    }
}