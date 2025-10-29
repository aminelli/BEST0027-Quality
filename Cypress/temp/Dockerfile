# Stage 1: Build
# FROM node:20.11.0-alpine AS builder
FROM node:16.20.2 AS builder

# Imposta la directory di lavoro
WORKDIR /app

# Copia i file di dipendenze
COPY package*.json ./

# Installa le dipendenze
RUN npm ci --only=production=false

# Copia il codice sorgente
COPY . .

# Build dell'applicazione Angular per produzione
RUN npm run build -- --configuration production

# Stage 2: Runtime
FROM nginx:1.25-alpine

# Copia la configurazione nginx personalizzata
COPY nginx.conf /etc/nginx/conf.d/default.conf

# Copia i file buildati dal builder stage
COPY --from=builder /app/dist/[nome-app] /usr/share/nginx/html

# Esponi la porta 80
EXPOSE 80

# Comando di avvio nginx
CMD ["nginx", "-g", "daemon off;"]