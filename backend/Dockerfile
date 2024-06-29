# Use the official Node.js image
FROM node:14

# Create app directory 
WORKDIR /usr/src/app

# Install app dependencies
COPY package*.json ./
RUN npm install

# Rebuild native modules for bcrypt
RUN npm rebuild bcrypt --build-from-source

# Bundle app source
COPY . .

# Expose the port that the app runs on
EXPOSE 8000

# Command to run the app
CMD ["npm", "start"]