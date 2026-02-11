import React, { createContext, useContext, useState } from "react";
import { useAuthService } from "../services/authService";

interface AuthContextProps {
    isAuthenticated: boolean;
    login: (email: string, password: string) => Promise<void>;
    logout: () => void;
}

const AuthContext = createContext({} as AuthContextProps);

export function AuthProvider({ children }: { children: React.ReactNode }) {
    const authService = useAuthService();
    const [isAuthenticated, setIsAuthenticated] = useState(!!localStorage.getItem("token"));

    async function login(email: string, password: string) {
        const response = await authService.login({ email, password });
        localStorage.setItem("token", response.data.token);
    }

    function logout() {
        localStorage.removeItem("token");
        setIsAuthenticated(false);
    }

    return(
        <AuthContext.Provider value={{ isAuthenticated, login, logout }}>
            { children }
        </AuthContext.Provider>
    )
}

export function useAuth() {
    return useContext(AuthContext);
}