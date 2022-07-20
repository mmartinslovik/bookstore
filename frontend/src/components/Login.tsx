import React, {useState} from "react";
import axios from "axios";

const loginUser = async (email: string | undefined, password: string | undefined): Promise<string | null> => {
    return axios.post('http://localhost:8080/auth/login', {
        email: email,
        password: password
    })
        .then(function (response) {
            console.log(response.data["jwt-token"]);
            return response.data["jwt-token"];
        })
        .catch(function (error) {
            console.log(error);
        });
}

export interface LoginProps {
    setToken: React.Dispatch<React.SetStateAction<string | null>>;
}

export default function Login({setToken}: LoginProps) {
    const [email, setEmail] = useState<string>();
    const [password, setPassword] = useState<string>();

    const handleSubmit = async (e: { preventDefault: () => void }) => {
        e.preventDefault();
        const token = await loginUser(email, password);
        setToken(token);
    }


    return (
        <div className="flex justify-center my-2 mx-4 mt-4 md:mx-0">
            <form className="w-full max-w-xl bg-white border p-20 bg-opacity-10" onSubmit={handleSubmit}>
                <div className="flex flex-wrap -mx-3 mb-6">
                    <div className="w-full md:w-full px-3 mb-6">
                        <label className="text-sm text-gray-900 font-medium px-6 py-4 whitespace-nowrap"
                               htmlFor='Password'>Email address</label>
                        <input
                            className="appearance-none block w-full bg-white text-gray-900 font-medium border border-gray-400 rounded py-3 px-3 leading-tight focus:outline-none"
                            type='email' required onChange={e => setEmail(e.target.value)}/>
                    </div>
                    <div className="w-full md:w-full px-3 mb-6">
                        <label className="text-sm text-gray-900 font-medium px-6 py-4 whitespace-nowrap"
                               htmlFor='Password'>Password</label>
                        <input
                            className="appearance-none block w-full bg-white text-gray-900 font-medium border border-gray-400 rounded py-3 px-3 leading-tight focus:outline-none"
                            type='password' required onChange={e => setPassword(e.target.value)}/>
                    </div>
                    <div className="w-full md:w-full px-3 mb-6 mt-6">
                        <button
                            type="submit"
                            className="w-full border border-gray-700 bg-gray-700 text-white rounded-md py-3 transition duration-500 ease select-none hover:bg-gray-800 focus:outline-none focus:shadow-outline">
                            Sign in
                        </button>
                    </div>
                </div>
            </form>
        </div>
    )
}