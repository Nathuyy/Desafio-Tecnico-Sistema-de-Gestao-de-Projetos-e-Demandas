import type { AxiosResponse } from "axios";
import type {
  LoginRequest,
  LoginResponse,
  RegisterRequest,
  RegisterResponse
} from "../types/auth";
import { api } from "./api";

export function useAuthService() {

  function login(data: LoginRequest): Promise<AxiosResponse<LoginResponse>> {
    return api.post("/auth/login", data);
  }

  function register(data: RegisterRequest): Promise<AxiosResponse<RegisterResponse>> {
    return api.post("/auth/register", data);
  }

  return {
    login,
    register
  };
}
