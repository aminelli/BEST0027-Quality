# Stage 1: Build
#FROM node:20.11.0-alpine AS builder
FROM node:16.20.2-alpine3.18 AS builder

# Imposta la directory di lavoro
WORKDIR /app

# Copia i file di dipendenze
COPY package*.json ./

# Installa le dipendenze
RUN npm ci --only=production=false

# Copia il codice sorgente
COPY . .

# Build dell'applicazione Angular per produzione
RUN npm run build 

# Stage 2: Runtime
FROM nginx:1.25-alpine


# Copia i file buildati dal builder stage
COPY --from=builder /app/dist/* /usr/share/nginx/html

# Copia la configurazione nginx personalizzata
COPY nginx.conf /etc/nginx/conf.d/default.conf


# Esponi la porta 80
EXPOSE 80

# Comando di avvio nginx
CMD ["nginx", "-g", "daemon off;"]