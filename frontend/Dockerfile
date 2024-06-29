# Use the official Node.js image
FROM node:14

# Create app directory
WORKDIR /usr/src/app

# Install app dependencies
COPY package*.json ./
RUN npm install

# Bundle app source
COPY . .

# Build the app for production
RUN npm run build

# Install serve to serve the built app
RUN npm install -g serve

# Expose the port that the app runs on
EXPOSE 3000

# Command to serve the built appy
CMD ["serve", "-s", "build"]