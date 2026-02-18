import {
  Box,
  TextField,
  Button,
  Typography,
  Paper,
  Link,
} from "@mui/material";
import { useNavigate } from "react-router-dom";

export function RegisterPage() {
  const navigate = useNavigate();

  return (
    <Box
      sx={{
        minHeight: "100vh",
        display: "flex",
        alignItems: "center",
        justifyContent: "center",
        bgcolor: "#f5f5f5",
      }}
    >
      <Paper elevation={3} sx={{ padding: 4, width: 360 }}>
        <Typography variant="h5" fontWeight="bold" mb={2}>
          Criar conta
        </Typography>

        <Typography variant="body2" mb={3} color="text.secondary">
          Leva menos de 1 minuto 🚀
        </Typography>

        <Box display="flex" flexDirection="column" gap={2}>
          <TextField
            label="Nome"
            fullWidth
          />

          <TextField
            label="Email"
            type="email"
            fullWidth
          />

          <TextField
            label="Senha"
            type="password"
            fullWidth
          />

          <TextField
            label="Confirmar senha"
            type="password"
            fullWidth
          />

          <Button variant="contained" size="large">
            Criar conta
          </Button>

          <Typography variant="body2" textAlign="center">
            Já possui conta?{" "}
            <Link
              component="button"
              onClick={() => navigate("/")}
            >
              Entrar
            </Link>
          </Typography>
        </Box>
      </Paper>
    </Box>
  );
}
