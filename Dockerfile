FROM java:17-alpine

# Set the working directory to /app
WORKDIR /app

COPY ./build/libs/*.jar ./app.jar

# Expose port 80
EXPOSE 80

# Start the application
CMD ["java", "-jar", "app.jar"]